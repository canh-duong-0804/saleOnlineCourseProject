package Controller.ClientNews;

import DAO.searchNewsFromDAO;
import Model.News;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import Controller.ManageBlogController.showBlogDetails;

public class searchAjaxNewsClients extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        searchNewsFromDAO find = new searchNewsFromDAO();
        String search = req.getParameter("search");
        System.out.println("Search name: " + search);
        String option = req.getParameter("filter");
        String indexPage = req.getParameter("index");
        if (indexPage.equals("-1")) {
            indexPage = "1";
        }
        System.out.println("Check index page: " + indexPage);
        System.out.println(option);

        int index = Integer.parseInt(indexPage);
        int count = find.getTotalSearch(search);
        System.out.println("Search: " + search);
        System.out.println("count: " + count);
        int endPage = count / 3;
        if (count % 3 != 0) {
            endPage++;
        }
        List<News> data = find.SearchForNameNewsClients(search, index);

        PrintWriter out = resp.getWriter();
        for (News item : data) {

            out.println("<div class=\"col-lg-6 wow fadeInUp\" style=\"width: 400px;height: 250px\">");
            out.println("    <div class=\"position-relative h-100\">");
            out.println("        <div class=\"custom-div\">");
            out.println("      <img class=\"img-fluid position-absolute w-100 h-100\" src=\""+item.getNewsImg()+"\">");
            out.println("        </div>");
            out.println("    </div>");
            out.println("</div>");
            out.println("<div class=\"col-lg-6 wow fadeInUp\">");
            out.println("    <h6 class=\"section-title bg-white text-start text-primary pe-3\" style=\"font-size: 20px\">" + item.getNewsTypeID() + "</h6>");
            out.println("    <h1 class=\"mb-4\"><a style=\"color: #20542b\" href=\"viewblogdetails/tintuc-" + showBlogDetails.convertToSlug(item.getNewsTitle().replaceAll(" ","-")) + "\">" + item.getNewsTitle() + "</a></h1>");
            out.println("    <p class=\"mb-4\">" + item.getNews() + "...</p>");
            out.println("    <div class=\"row gy-2 gx-4 mb-4\">");
            out.println("        <div class=\"col-sm-6\">");
            out.println("            <p class=\"mb-0\"><i class=\"fa fa-arrow-right text-primary me-2\"></i>Skilled Instructors</p>");
            out.println("        </div>");
            out.println("    </div>");
            out.println("    <a class=\"btn btn-primary py-3 px-5 mt-2\" href=\"viewblogdetails?id=" + item.getNewsID() + "\">Read More</a>");
            out.println("</div>");

        }
        out.print("\n"
                + "                                                        <nav aria-label=\"Page navigation\">\n"
                + "                                                            <ul class=\"pagination justify-content-end\">\n"
                + "                                                                <li class=\"page-item\">\n"
                + "                                                                    <button type=\"button\" class=\"page-link\"  " + (index > 1 ? "" : "disabled") + "  onclick=\"search(" + (index - 1) + ")\" aria-label=\"Previous\">\n"
                + "                                                                        <span aria-hidden=\"true\">&laquo;</span>\n"
                + "                                                                        <span class=\"sr-only\">Previous</span>\n"
                + "                                                                    </button>\n"
                + "                                                                </li>\n");

        for (int i = 1; i <= endPage; i++) {
            out.print("<li class=\"page-item " + (index == i ? "active" : "") + " \">\n"
                    + "                                                                        <button class=\"page-link\" type=\"button\" name=\"pageLink\" id=\"pageLink\" onclick=\"search(" + i + ")\">" + i + "</button>\n"
                    + "                                                                    </li>");
        }

        out.print("                                                                <li class=\"page-item\">\n"
                + "                                                                    <button type=\"button\" class=\"page-link\" " + (index < endPage ? "" : "disabled") + " onclick=\"search(" + (index + 1) + ")\" aria-label=\"Next\">\n"
                + "                                                                        <span aria-hidden=\"true\">&raquo;</span>\n"
                + "                                                                        <span class=\"sr-only\">Next</span>\n"
                + "                                                                    </button>\n"
                + "                                                                </li>\n"
                + "                                                            </ul>\n"
                + "                                                        </nav>  \n"
                + "                                                    ");

    }
}
