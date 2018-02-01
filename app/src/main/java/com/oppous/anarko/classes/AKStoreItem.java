package com.oppous.anarko.classes;

import org.json.JSONArray;

/**
 * Created by peter on 11/2/2016.
 */
public class AKStoreItem {
    public String idx;
    public String name;
    public String description;
    public String type;
    public double price;
    public int isPrivate=0;
    public String creator;
    public int minVersionReq=1;
    public JSONArray actions;
    public int __v=0;
    public int active=0;
    public JSONArray thumbs;
    public JSONArray packages;
    public int isFree=0;

    public JSONArray resources;
}
