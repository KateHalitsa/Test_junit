<html>
<HEAD>
<TITLE>Использование JavaServer Pages</TITLE>
<META NAME="author" CONTENT="Marty Hall -- hall@apl.jhu.edu">
<META NAME="keywords"
 CONTENT="JSP,JavaServer Pages,servlets">
<META NAME="description"
 CONTENT=" JSP.">
<LINK REL=STYLESHEET
 HREF="My-Style-Sheet.css"
 TYPE="text/css">
</HEAD>
<body BGCOLOR="#FDF5E6" TEXT="#000000" LINK="#0000EE"
       VLINK="#551A8B" ALINK="#FF0000" leftmargin="25" topmargin="25">

<%@ page import="javax.xml.parsers.DocumentBuilder, javax.xml.parsers.DocumentBuilderFactory, org.w3c.dom.Document, org.w3c.dom.NodeList, org.w3c.dom.Node,org.w3c.dom.Element, org.xml.sax.SAXException,javax.xml.parsers.ParserConfigurationException,java.util.List,java.util.ArrayList" %>
      <%@ page import="java.io.IOException, java.net.URL" %>
      <%@ page contentType="text/html; charset=UTF-8" %>
<%
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
int fullCost=0;
int cost=0;
String title = null;
            String schedule = null;

            String description = null;
            String rating = null;
    // Обход списка элементов
   /**/  for (int i = 0; i < nodeList.getLength(); ++i) {
                        Element film = (Element) nodeList.item(i);
                        List<String> genres = new ArrayList();
                        String isbn = film.getAttribute("isbn");
                        /* */
                        NodeList props = film.getElementsByTagName("*");

                        for (int j = 0; j < props.getLength(); j++) {
                            Element prop = (Element) props.item(j);

                            if ("c:title".equals(prop.getTagName())) {
                                title = prop.getTextContent();

                            } else if ("c:genre".equals(prop.getTagName())) {
                                genres.add(prop.getTextContent());

                            } else if ("c:schedule".equals(prop.getTagName())) {
                                schedule = prop.getTextContent();

                            } else if ("c:description".equals(prop.getTagName())) {
                                description = prop.getTextContent();

                            } else if ("c:rating".equals(prop.getTagName())) {

                                rating = prop.getTextContent();

                            }

                            else if ("c:cost".equals(prop.getTagName())) {
cost= Integer.parseInt (prop.getTextContent());


                            }

                        }
     // String value = node.getTextContent();

      // Вывод информации на страницу
     out.println("Название: " + title + "<br>");
     out.println("Жанры: ");
      for (int k = 0; k < genres.size(); ++k) {
      out.println(genres.get(k));
      }
 out.println("<br>Расписание: " + schedule + "<br>");
 out.println("Рейтинг: " + rating + "<br>");
  out.println("Описание: " + description + "<br>");
   out.println("Цена за билет: " + cost + " р.<br><br>");
      // Извлечение информации из элемента
fullCost += cost;


    }
out.println("Общая стоимость  : " + fullCost + "р.<br>");
  } catch (Exception e) {
    e.printStackTrace();
    out.println("Ошибка загрузки XML: " + e.getMessage());
  }
%>
</body>
</html>
