package utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SerializerXML implements SerializerAPI
{

  @SuppressWarnings("rawtypes")
private Stack stack = new Stack();
  private File file;

  public SerializerXML(File file)
  {
    this.file = file;
  }

  @SuppressWarnings("unchecked")
public void push(Object o)
  {
    stack.push(o);
  }

  public Object pop()
  {
    return stack.pop(); 
  }

  @SuppressWarnings({ "rawtypes" })
  public void read() throws Exception
  {
    ObjectInputStream is = null;

    try
    {
    	 XStream xstream = new XStream(new DomDriver());
         is =  xstream.createObjectInputStream(new FileReader(file));
      stack = (Stack) is.readObject();
    }
    finally
    {
      if (is != null)
      {
        is.close();
      }
    }
  }

  public void write() throws Exception
  {
    ObjectOutputStream os = null;

    try
    {
    XStream xstream = new XStream(new DomDriver());
      os =  xstream.createObjectOutputStream(new FileWriter(file));
      os.writeObject(stack);
    }
    finally
    {
      if (os != null)
      {
        os.close();
      }
    }
  }
}
