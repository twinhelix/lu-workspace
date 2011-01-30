#include <iostream>

#include "Image.h"
#include "HaarWavelet.h"
using namespace std;

template <class type>
type stringTo (const char in[])
{
  std::istringstream tmp(in);
  type out;
  tmp>>out;
  return out;
}

template <class type>
type stringTo (string& in)
{
  std::istringstream tmp(in);
  type out;
  tmp>>out;
  return out;
}

int main (int argc, char *argv[])
{
  srand(time(0));

  if (argc < 3) {
    cout << "Usage: haar fileIn fileOut [options]" << endl;
    cout << "Option -s: use standard wavelet transform" << endl;
    cout << "Option -n: use nonstandard wavelet transform" << endl;
    cout << "Option -tol [value]: tolerance (between 0 and 1), for forward transform only" << endl;
    cout << "Default options are -s -tol 0.5" << endl;
    exit(-1);
  }

  // Default tolerance
  double tol = 0.5;

  // Default method
  int method = HaarWavelet::STANDARD;

  // Input filename
  string input_filename = argv[1];
  argv++;
  argc--;

  // Output filename
  string output_filename = argv[1];
  argv++;
  argc--;

  // Parse remaining options
  bool ok;
  while (argc > 1) {
    ok = false;
    if ((ok == false) && (strcmp(argv[1], "-tol") == 0)) {
      argc--;
      argv++;
      tol = stringTo<double>(argv[1]);
      argc--;
      argv++;
      ok = true;
    }
    if ((ok == false) && (strcmp(argv[1], "-s") == 0)) {
      argc--;
      argv++;
      method = HaarWavelet::STANDARD;
      ok = true;
    }
    if ((ok == false) && (strcmp(argv[1], "-n") == 0)) {
      argc--;
      argv++;
      method = HaarWavelet::NONSTANDARD;
      ok = true;
    }
    if (ok == false) {
      cerr << "Can not parse argument " << argv[1] << endl;
      cout << "Usage: haar fileIn fileOut [options]" << endl;
      cout << "Option -s: use standard wavelet transform" << endl;
      cout << "Option -n: use nonstandard wavelet transform" << endl;
      cout << "Option -tol [value]: tolerance (between 0 and 1), for forward transform only" << endl;
      cout << "Default options are -s -tol 0.5" << endl;
      exit(0);
    }
  }

  Image tmp, input, output;

  // Read image
  cout << "Reading image ... " << endl;
  if (!input.read(input_filename)) {
    cout << "Cannot read image from file " << argv[1] << endl;
    exit(1);
  }

  // Create Haar encoder
  if (method == HaarWavelet::STANDARD) {
    cout << "Performing standard wavelet transform" << endl;
  } else {
    if (method == HaarWavelet::NONSTANDARD) {
      cout << "Performing non-standard wavelet transform" << endl;
    } else {
      cout << "No wavelet transformation specified" << endl;
      exit(1);
    }
  }

  cout << "Encoding ..." << endl;
  HaarWavelet HaarEncoder(input, method);
  HaarEncoder.ForwardTransform(tmp);

  cout << "Discarding " << tol*100 << "% of the details" << endl;
  HaarEncoder.discardDetail(tmp, tol);

  cout << "Decoding ..." << endl;
  HaarWavelet haarDecoder(tmp, method);
  haarDecoder.ReverseTransform(output);

  // Write output
  cout << "Writing image..." << endl;
  if (!output.write(output_filename)) {
    cout << "File writing error!" << endl;
  }

  return 0;
}

