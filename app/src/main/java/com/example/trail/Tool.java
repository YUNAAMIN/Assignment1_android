package com.example.trail;

public class Tool {// this class is to represent the tools and its atribuets for exp name,image,steps
    private String name;// the tools names
    private int srcid;// this take the pic id and ii take it
    private String steps;// the steps as a description i think

    public Tool(String name, int srcid, String steps) {// argument construvtot that take name discrittion is,steps
        this.name = name;
        this.srcid = srcid;
        this.steps = steps;
    }

    public String getName() {// get the name

        return name;
    }

    public int getImageResourceId() {// getth eimage sousce name

        return srcid;
    }

    public String getSteps() {// this methid is to get steps
        return steps;

    }
}
