package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import java.io.IOException;
import java.net.URL;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<html>\r\n");
      out.write("<body>\r\n");
      out.write("<h2>Hello World!</h2>\r\n");
      out.write("<h2>Hello World!</h2>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

  // URL или путь к XML-файлу
  String xmlPath = "file:/C:/Sitaris/cinema.xml";

  try {
    // Создание фабрики для создания парсера
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    // Создание парсера
    DocumentBuilder builder = factory.newDocumentBuilder();

    // Загрузка XML-документа
    Document document = builder.parse(new URL(xmlPath).openStream());

    // Получение списка элементов из XML
    NodeList nodeList = document.getElementsByTagName("c:film");

    // Обход списка элементов
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);

      // Извлечение информации из элемента
      String value = node.getTextContmvnent();

      // Вывод информации на страницу
      out.println("Значение элемента: " + value + "<br>");
    }

  } catch (Exception e) {
    e.printStackTrace();
    out.println("Ошибка загрузки XML: " + e.getMessage());
  }

      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
