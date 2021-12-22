package com.netflix.zuul.filters;

import java.lang.*;
import java.io.*;
import java.net.*;
import java.util.*;
import groovy.lang.*;
import groovy.util.*;

public abstract class SurgicalDebugFilter
  extends com.netflix.zuul.ZuulFilter  implements
    groovy.lang.GroovyObject {
;
public  groovy.lang.MetaClass getMetaClass() { return (groovy.lang.MetaClass)null;}
public  void setMetaClass(groovy.lang.MetaClass mc) { }
public  java.lang.Object invokeMethod(java.lang.String method, java.lang.Object arguments) { return null;}
public  java.lang.Object getProperty(java.lang.String property) { return null;}
public  void setProperty(java.lang.String property, java.lang.Object value) { }
public abstract  boolean patternMatches();
@java.lang.Override() public  java.lang.String filterType() { return (java.lang.String)null;}
@java.lang.Override() public  int filterOrder() { return (int)0;}
public  boolean shouldFilter() { return false;}
@java.lang.Override() public  java.lang.Object run() { return null;}
}
