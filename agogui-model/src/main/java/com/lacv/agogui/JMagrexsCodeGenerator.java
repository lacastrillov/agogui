/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lacv.agogui;

import com.lacv.jmagrexs.generator.CodeGenerator;


/**
 *
 * @author lacastrillov
 */
public class JMagrexsCodeGenerator {
    
    public static void main(String[] args){
        System.out.print("Hola Generador");
        CodeGenerator codeGenerator= new CodeGenerator(JMagrexsCodeGenerator.class, "com.lacv.agogui");
        
        //codeGenerator.generate("com.lacv.agogui.model.entities");
        
        codeGenerator.getMapperGenerator().generate("com.lacv.agogui.model.entities");
    }
    
}
