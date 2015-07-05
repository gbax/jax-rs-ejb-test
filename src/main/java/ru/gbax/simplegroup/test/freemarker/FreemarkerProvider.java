package ru.gbax.simplegroup.test.freemarker;

import freemarker.template.*;

import java.io.*;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;

/**
 * Created by GBAX on 04.07.2015.
 */

public class FreemarkerProvider {

    private static FreemarkerProvider fp;
    private static Configuration cfg;
    private static String tempType = ".ftl";

    public FreemarkerProvider() {
    }

    public static FreemarkerProvider init() throws IOException {
        if(fp == null) {
            fp = new FreemarkerProvider();
            cfg = new Configuration();
            final URL resource = fp.getClass().getClassLoader().getResource("../templates");
            cfg.setDirectoryForTemplateLoading(new File(resource.getPath()));
            cfg.setTemplateUpdateDelay(0);
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
            cfg.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
            cfg.setDefaultEncoding("ISO-8859-1");
            cfg.setOutputEncoding("UTF-8");
            cfg.setLocale(Locale.US);
        }
        return fp;
    }

    public static ByteArrayOutputStream templateProcess(Object viewModel, String view) throws IOException {
        if(cfg == null)
            init();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Writer out = new OutputStreamWriter(baos, "UTF-8");
        Template temp = cfg.getTemplate(view + tempType);
        if (viewModel == null) {
            viewModel = new HashMap<>();
        }
        try {
            temp.process(viewModel, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } finally {
            out.flush();
        }
        return baos;
    }

}
