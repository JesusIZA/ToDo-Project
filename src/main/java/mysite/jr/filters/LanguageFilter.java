package mysite.jr.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        System.out.println("LanguageFilter");

        String lang = request.getParameter("language");
        if(!Objects.isNull(lang) && !Objects.equals(lang, "") /*&& EnterDataValidator.isValidLanguage(lang)*/){
            HttpSession session = request.getSession();
            session.setAttribute("language", lang);
        }
        chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}