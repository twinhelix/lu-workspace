#include "HaarWavelet.h"
#include <iostream>

using namespace std;

const double SQRT2 = 1.414213562;

double abs(double x)
{
  return (x<0)?-x:x;
}

HaarWavelet::HaarWavelet(Image &image, int transformationType) : Image(image)
{
  m_type = transformationType;
}

void HaarWavelet::quicksort(const vector<double>& data, vector<unsigned int>& index, unsigned int start, unsigned int end)
{
  unsigned int middle;

  if (start < end) {
    unsigned int ref = start + rand()%(end-start);

    double x = abs(data[index[ref]]);
    unsigned int i = start - 1;
    unsigned int j = end + 1;
    int temp;
    do {
      do {
        j--;
      } while (x >abs(data[index[j]]));

      do {
        i++;
      } while (x <abs(data[index[i]]));

      if (i < j) {
        // switch elements at positions i and j
        temp = index[i];
        index[i] = index[j];
        index[j] = temp;
      }
    } while (i < j);
    middle = j; // returns middle index

    quicksort(data, index, start, middle);
    quicksort(data, index, middle+1, end);
  }
  return;
}

void HaarWavelet::sortIndex(const vector<double>& data, vector<unsigned int>& index)
{
  index.resize(data.size());
  unsigned int i; for(i=0; i<index.size(); i++) index[i] = i;

  quicksort(data, index, 0, index.size()-1);
}

void HaarWavelet::ForwardTransform(Image& out)
{
  if (this->numRows() == 0 || this->numCols() == 0) return;

  double rowPower = log2(double(this->numRows()));
  double colPower = log2(double(this->numCols()));
  if (int(rowPower) != rowPower || int(colPower) != colPower) {
    cout << "Haar wavelet cannot deal with size that are not power of two" << endl;
    return;
  }

  if (m_type == STANDARD) {
    out.init(this->numRows(), this->numCols());
    int ret = standardDecomposition(out);
    if (ret) m_type = STANDARD;
    else cout<<"Standard decompression failed."<<endl;

  } else if(m_type == NONSTANDARD) {
    out.init(this->numRows(), this->numCols());
    int ret = nonStandardDecomposition(out);
    if(ret) m_type = NONSTANDARD;
    else cout<<"Non-standard decompression failed."<<endl;

  } else {
    cout<< "Transformation type error!"<<endl;
  }
}

void HaarWavelet::ReverseTransform(Image& out)
{
  if (m_type == NONE) return;

  if (out.numRows() != m_rows && out.numCols() != m_cols) {
    out.init(m_rows, m_cols);
  }
  if (m_type == STANDARD) {
    int ret = standardReconstruction(out);
    if (ret) m_type = STANDARD;
    return;
  } else {
    if (m_type == NONSTANDARD) {
      int ret = nonStandardReconstruction(out);
      if (ret) m_type = NONSTANDARD;
    } else {
      cout<< "Transformation type error!"<<endl;
    }
  }
}

void HaarWavelet::discardDetail(Image &image, double tol)
{
	// To be implemented
}

int HaarWavelet::standardDecomposition(Image &out)
{
	// To be implemented
	return 1;
}

int HaarWavelet::standardReconstruction(Image& out)
{
	// To be implemented
  return 1;
}

int HaarWavelet::nonStandardDecomposition(Image &out)
{
	// To be implemented
	return 1;
}

int HaarWavelet::nonStandardReconstruction(Image& out)
{
	// To be implemented
	return 1;
}
