<html>
<body>
<h2>Hello World!</h2>
<h2>Hello World!</h2>
<%@ page import="javax.xml.parsers.DocumentBuilder, javax.xml.parsers.DocumentBuilderFactory, org.w3c.dom.Document, org.w3c.dom.NodeList, org.w3c.dom.Node" %>
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

    // Обход списка элементов
    for (int i = 0; i < nodeList.getLength(); i++) {
      Node node = nodeList.item(i);

      // Извлечение информации из элемента
      String value = node.getTextContent();

      // Вывод информации на страницу
      out.println("Значение элемента: " + value + "<br>");
    }

  } catch (Exception e) {
    e.printStackTrace();
    out.println("Ошибка загрузки XML: " + e.getMessage());
  }
%>
</body>
</html>
