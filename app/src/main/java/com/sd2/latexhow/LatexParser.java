package com.sd2.latexhow;

import android.content.Context;
import android.util.Log;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import json.JsonReader;

public class LatexParser {
    JsonReader jsonHandler;
    ArrayList<String> questionArray;
    int questionCounter = 0;
    /*
    To get Read File from jsonHandler
    */
    public void setText(Context context){
        jsonHandler = new JsonReader(context.getApplicationContext());
        try {
            questionArray = jsonHandler.readFile();
            Log.d("TAG", "setText: "+questionArray.size());
        } catch (IOException | JSONException e) {
            e.printStackTrace();
        }
    }
    public String getLatex(){
        String explanation = questionArray.get(questionCounter);
        questionCounter++;
        return explanation;
    }
    /*
    Html logic to render latex
    Note: Changes are required only in this method
    */
    public String getHtml(){
        String p_tag="";
        String script="";
        String text = getLatex();
        if(text.contains("\\")){
            script = "<script type=\"math/tex\" id=\"MathJax-Element-2\">"+text +
                    "    </script>\n";
        }else{
            p_tag = "    <p>\n" +
                    text +
                    "    </p>\n";
        }
        String Html_template = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"utf-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "    <title></title>\n" +
                "</head>\n" +
                "<body>\n" +
                p_tag +
                 script+
                "<script type=\"text/x-mathjax-config;executed=true\">\n" +
                "     MathJax.Hub.Config({tex2jax: {inlineMath: [['\\\\(','\\\\)']]}});\n" +
                "</script>\n" +
                "<script src=\"https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.1/MathJax.js?config=TeX-AMS-MML_HTMLorMML\" id=\"\">\n" +
                "</script>\n" +
                "<script type=\"text/x-mathjax-config;executed=true\">\n" +
                "MathJax.Hub.Register.StartupHook(\"End Jax\",function () {\n" +
                " var BROWSER = MathJax.Hub.Browser;\n" +
                " var jax = \"SVG\";\n" +
                " //var jax = \"HTML-CSS\";\n" +
                " if (BROWSER.isMSIE && BROWSER.hasMathPlayer) jax = \"NativeMML\";\n" +
                " if (BROWSER.isFirefox) jax = \"SVG\";\n" +
                " if (BROWSER.isSafari && !BROWSER.isChrome && BROWSER.versionAtLeast(\"5.0\")) jax = \"NativeMML\";\n" +
                " return MathJax.Hub.setRenderer(jax);\n" +
                "});\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";
        return Html_template;
    }
}
