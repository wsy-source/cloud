package com.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class MyBlockHandler {

    public static String testHandlerBlock(BlockException blockException){
        return "/(ㄒoㄒ)/~~";
    }
}
