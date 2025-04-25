import com.google.gson.Gson;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

import java.util.*;

public class ScrapeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = request.getParameter("url");
        String[] options = request.getParameterValues("options");

        List<Map<String, String>> scrapedData = ScraperUtil.scrape(url, options);

        
        HttpSession session = request.getSession();
        session.setAttribute("scrapedData", scrapedData);

        
        request.getRequestDispatcher("display.jsp").forward(request, response);
        
        
        
        HttpSession session = request.getSession();


        Integer visitCount = (Integer) session.getAttribute("visitCount");
        if (visitCount == null) visitCount = 0;
        visitCount++;
        session.setAttribute("visitCount", visitCount);
    }
}
