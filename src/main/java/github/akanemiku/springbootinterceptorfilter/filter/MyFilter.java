package github.akanemiku.springbootinterceptorfilter.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器
 *
 * 可以用注解的方式，但多个过滤器无法指定先后顺序
 * @WebFilter(filterName = "myFilter",urlPatterns = "/api/*")
 * 需要在启动类加上@ServletComponentScan
 */
@Component
@Slf4j
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("初始化过滤器 [1号]："+filterConfig.getFilterName());
    }

    @Override
    public void destroy() {
        log.info("销毁过滤器 [1号]");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //对请求进行预处理
        log.info("过滤器 [1号] 开始对请求进行预处理：");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();
        log.info("请求的接口为：" + requestUri);
        long startTime = System.currentTimeMillis();
        //通过 doFilter 方法实现过滤功能
        filterChain.doFilter(servletRequest, servletResponse);

        //上面的 doFilter 方法执行结束后用户的请求已经返回
        long endTime = System.currentTimeMillis();
        log.info("请求处理完毕，花费的时间：" + (endTime - startTime));
    }
}
