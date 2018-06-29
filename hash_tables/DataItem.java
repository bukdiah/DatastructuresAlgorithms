import java.io.*;

class DataItem
{
  private int iData; // data item (key) We could have more data

  public DataItem(int ii) {
    iData = ii;
  }

  public int getKey() {
    return iData;
  }
}