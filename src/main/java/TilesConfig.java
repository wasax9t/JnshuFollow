//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
//import org.springframework.web.servlet.view.tiles3.TilesViewResolver;
//
//@Configuration
//@EnableWebMvc    //相当于<mvc:annotation-driven />
//@ComponentScan(basePackages = "cn.yxy.tiles")
//public class TilesConfig extends WebMvcConfigurerAdapter {
//
//	private static final String tilesXmlLocation="/WEB-INF/views/**/tiles.xml";
//	
//	/**
//     * Configure TilesConfigurer.
//     */
//	@Bean
//	public TilesConfigurer tilesConfigurer(){
//		TilesConfigurer tilesConfigurer = new TilesConfigurer();
//		tilesConfigurer.setDefinitions(new String[] {tilesXmlLocation});
//		tilesConfigurer.setCheckRefresh(true);
//		return tilesConfigurer;
//	}
//	
//	/**
//     * Configure ViewResolvers to deliver preferred views.
//     */
//    @Override
//    public void configureViewResolvers(ViewResolverRegistry registry) {
//        TilesViewResolver viewResolver = new TilesViewResolver();
//        registry.viewResolver(viewResolver);
//    }
//     
//    /**
//     * Configure ResourceHandlers to serve static resources like CSS/ Javascript etc...
//     */
//     
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//    }
//}
