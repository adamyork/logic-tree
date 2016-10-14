package com.github.adamyork.logictree;
import java.util.function.Function;

public class LogicTreeTestHandlers {
    
    private static String results = "";
    
    public static Function<Object,Void> getHandler1(){
        return new Function<Object, Void>() {
            @Override
            public Void apply(Object t) {
                results += "branch1-";
                return null;
            }
        };
    }
    
    public static Function<Object,Void> getHandler2(){
        return new Function<Object, Void>() {
            @Override
            public Void apply(Object t) {
                results += "branch2-";
                return null;
            }
        };
    }
    
    public static Function<Object,Void> getHandler1_1(){
        return new Function<Object, Void>() {
            @Override
            public Void apply(Object t) {
                results += "branch1.1-";
                return null;
            }
        };
    }
    
    public static Function<Object,Void> getHandler1_2(){
        return new Function<Object, Void>() {
            @Override
            public Void apply(Object t) {
                results += "branch1.2-";
                return null;
            }
        };
    }
    
    public static Function<Object,Void> getHandler1_1_1(){
        return new Function<Object, Void>() {
            @Override
            public Void apply(Object t) {
                results += "branch1.1.1-";
                return null;
            }
        };
    }
    
    public static Function<Object,Void> getHandler1_1_2(){
        return new Function<Object, Void>() {
            @Override
            public Void apply(Object t) {
                results += "branch1.1.2-";
                return null;
            }
        };
    }
    
    public static Function<Object,Void> getHandler1_1_1_1(){
        return new Function<Object, Void>() {
            @Override
            public Void apply(Object t) {
                results += "branch1.1.1.1-";
                return null;
            }
        };
    }
    
    public static String getResults(){
        return results;
    }
    
    public static void setResults(String results){
        LogicTreeTestHandlers.results = results;
    }

}