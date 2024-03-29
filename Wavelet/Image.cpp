#include "Image.h"

Image::Image()
{
  m_max = 0;
  m_cols = m_rows = 0;
}

Image::Image(const Image& ref):vector<double>(ref)
{
  m_max = ref.m_max;
  m_cols = ref.m_cols;
  m_rows = ref.m_rows;
}

Image::Image(int rows, int cols)
{
  init(rows, cols);
}

Image::~Image()
{}

void Image::init (int rows, int cols)
{
  m_max = 0;
  m_cols = cols;
  m_rows = rows;
  resize(rows*cols);
}

int Image::read(string fileName)
{
  ifstream in (fileName.c_str());
  if(!in.is_open()) return 0;

  char buffer[MAX_PGM_LINE_NUMBER];
  in.getline(buffer, MAX_PGM_LINE_NUMBER);

  string magic = string(buffer);
  if(magic == "P5") { //Normal PGM
    //Get rid of comments
    for (in.getline(buffer, MAX_PGM_LINE_NUMBER); buffer[0] == '#'; in.getline(buffer, MAX_PGM_LINE_NUMBER));
    //read column and row
    stringstream sizeStream(buffer);
    sizeStream >> m_cols;
    sizeStream >> m_rows;
    init(m_rows, m_cols);

    //Get rid of comments
    for (in.getline(buffer, MAX_PGM_LINE_NUMBER); buffer[0] == '#'; in.getline(buffer, MAX_PGM_LINE_NUMBER));
    //read max value
    stringstream maxStream(buffer);
    maxStream >> m_max;
    int pixByte = (m_max < 256 )?1:2 ;

    unsigned int pixel;
    unsigned char byte[1];

    unsigned int i; for(i = 0; i < size(); i++) {
      pixel =0;
      if(pixByte == 2) {
        in.read((char*)byte,1);
        pixel += byte[0]<<8;
      }
      in.read((char*)byte,1);
      pixel += byte[0];

      (*this)[i] = pixel;
    }
  } else if(magic == "P2") { //plain PGM
    cout <<"Raw PGM reading has not been implemented." <<endl;
    return 0;

  } else {
    cout <<"Incorrect PGM magic number" <<endl;
    return 0;
  }
  return 1;
}

int Image::write(string fileName)
{
  ofstream out(fileName.c_str());
  if(!out.is_open()) return 0;

  out<<"P5"<<endl;
  out<<"# File created at ";

  char* hostName = getenv("HOST");
  if (hostName) out<<hostName;
  char* user = getenv("USER");
  if (user) out <<" by "<< user;

  time_t rawtime;
  tm * timeinfo;
  time ( &rawtime );
  timeinfo = localtime ( &rawtime );
  out<<" at "<< asctime (timeinfo);

  out<<m_cols<<" "<< m_rows<<endl;

  double min=0;
  m_max = 0;
  unsigned int i; for(i = 0; i < size(); i++) {
    if(m_max < (*this)[i]) m_max = (*this)[i];
    if(min > (*this)[i]) min = (*this)[i];
  }
  if (min <0) {
    for(i = 0; i < size(); i++) (*this)[i] -= min;
    m_max -=min;
    min =0;
  }
  if (m_max > 255) {
    double scale = 255.0/m_max;
    for(i = 0; i < size(); i++) {
      (*this)[i] *= scale;
    }
    m_max = 255;

  }

  out<<int(m_max)<<endl;

  unsigned int pixel;
  unsigned char byte[1];

  for(i = 0; i < size(); i++) {
    pixel = int(round(min+(*this)[i]));
    byte[0] = (unsigned char)(pixel);
    out.write((char*)byte, 1);

  }

  out.close();
  return 1;
}

vector <double> Image::extractCol(int colNum)const
{
  vector <double> ret (m_rows);
  unsigned int i; for(i=0; i<m_rows; i++) ret[i] = (*this)[i*m_cols + colNum];
  return ret;
}

vector <double> Image::extractRow(int rowNum)const
{
  vector <double> ret (m_cols);
  unsigned int i; for(i=0; i<m_cols; i++) ret[i] = (*this)[rowNum * m_cols + i];
  return ret;
}

void Image::fillCol(int colNum, vector <double> in)
{
  unsigned int i; for(i=0; i<m_rows; i++) (*this)[i* m_cols + colNum]= in[i];
}

void Image::fillRow(int rowNum, vector <double> in)
{
  unsigned int i; for(i=0; i<m_cols; i++) (*this)[rowNum * m_cols + i]= in[i];
}

unsigned int Image::numRows()const
{
  return m_rows;
}
unsigned int Image::numCols()const
{
  return m_cols;
}

double Image::getData(unsigned int row, unsigned int col)const
{
  return (*this)[row * m_cols + col];
}

void Image::setData(unsigned int row, unsigned int col, double val)
{
  if(row<m_rows && col<m_cols && row >=0 && col>=0) (*this)[row*m_cols + col] = val;
}

