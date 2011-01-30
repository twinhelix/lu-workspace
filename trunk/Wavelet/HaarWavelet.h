#ifndef HARRWAVELET_H_
#define HARRWAVELET_H_

// Global includes
#include <string>
#include <math.h>
#include <vector>

// Local includes
#include "Image.h"

using namespace std;

class HaarWavelet : public Image
{

private:

  int m_type; //compression type flag

  int standardDecomposition(Image &out);
  int standardReconstruction(Image& out);

  int nonStandardDecomposition(Image &out);
  int nonStandardReconstruction(Image& out);

  void quicksort(const vector<double>& data, vector<unsigned int>& index, unsigned int start, unsigned int end);
  void sortIndex(const vector<double>& data, vector<unsigned int>& index);

public:

  // Type of wavelet transform
  const static int NONE        = 0;
  const static int STANDARD    = 1;
  const static int NONSTANDARD = 2;

  // Constructor
  HaarWavelet();

  // Constructor
  HaarWavelet(Image &image, int type);

  // Copy constructor
  HaarWavelet(const HaarWavelet& ref);

  // Discard detail coefficients
  void discardDetail(Image &image, double tol);

  // Run forward transform
  void ForwardTransform(Image& out);

  // Run reverse transform
  void ReverseTransform(Image& out);

  // Return decomposition type
  int decompositionType();

};

// Constructor
inline HaarWavelet::HaarWavelet():Image()
{
  m_type = NONE;
}

// Constructor
inline HaarWavelet::HaarWavelet(const HaarWavelet& ref) : Image((Image)ref)
{
  m_type = ref.m_type;
}

// Returns decomposition type
inline int HaarWavelet::decompositionType()
{
  return m_type;
}

#endif

