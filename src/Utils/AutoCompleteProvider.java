/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import org.fife.ui.autocomplete.BasicCompletion;
import org.fife.ui.autocomplete.CompletionProvider;
import org.fife.ui.autocomplete.DefaultCompletionProvider;
import org.fife.ui.autocomplete.ShorthandCompletion;

/**
 *
 * @author Hugo Luna
 */
public class AutoCompleteProvider {

    /**
     * Create a simple provider that adds some Java-related completions.
     */
    public CompletionProvider createCompletionProvider() {

        // A DefaultCompletionProvider is the simplest concrete implementation
        // of CompletionProvider. This provider has no understanding of
        // language semantics. It simply checks the text entered up to the
        // caret position for a match against known completions. This is all
        // that is needed in the majority of cases.
        DefaultCompletionProvider provider = new DefaultCompletionProvider();

        // Add completions for all Java keywords. A BasicCompletion is just
        // a straightforward word completion.
        provider.addCompletion(new BasicCompletion(provider, "abstract"));
        provider.addCompletion(new BasicCompletion(provider, "assert"));
        provider.addCompletion(new BasicCompletion(provider, "break"));
        provider.addCompletion(new BasicCompletion(provider, "case"));
        // ... etc ...
        provider.addCompletion(new BasicCompletion(provider, "transient"));
        provider.addCompletion(new BasicCompletion(provider, "try"));
        provider.addCompletion(new BasicCompletion(provider, "void"));
        provider.addCompletion(new BasicCompletion(provider, "volatile"));
        provider.addCompletion(new BasicCompletion(provider, "while"));

        // Add a couple of "shorthand" completions. These completions don't
        // require the input text to be the same thing as the replacement text.
        
        provider.addCompletion(new ShorthandCompletion(provider, "main", "static void main() {}", "Estructura basica de método pricipal"));
        provider.addCompletion(new ShorthandCompletion(provider, "iInt", "(System.readInt());", "El flujo de entrada \"estándar\". Esta secuencia ya está abierta y lista para proporcionar datos de entrada de tipo entero"));
        provider.addCompletion(new ShorthandCompletion(provider, "iStr", "(System.readString());", "El flujo de entrada \"estándar\". Esta secuencia ya está abierta y lista para proporcionar datos de entrada de tipo cadena"));
        
        provider.addCompletion(new ShorthandCompletion(provider, "printIln","(System.printIln());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo entero con salto de linea. "));
        provider.addCompletion(new ShorthandCompletion(provider, "printI","(System.printIln());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo entero. "));

        provider.addCompletion(new ShorthandCompletion(provider, "printIO","(System.printSIO());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo cadena(Solo los accede a datos introducidos en tiempo de ejecución). "));
        
        provider.addCompletion(new ShorthandCompletion(provider, "printBln", "(System.printBln());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo booleano con salto de linea. "));
        provider.addCompletion(new ShorthandCompletion(provider, "printB", "(System.printBln());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo booleano. "));

        provider.addCompletion(new ShorthandCompletion(provider, "printSln", "(System.printSln());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo cadena con salto de linea. "));
        provider.addCompletion(new ShorthandCompletion(provider, "printS", "(System.printS());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo cadena. "));

        provider.addCompletion(new ShorthandCompletion(provider, "printCln", "(System.printCln());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo caracter con salto de linea. "));
        provider.addCompletion(new ShorthandCompletion(provider, "printC", "(System.printC());", "El flujo de salida \"estándar\". Esta secuencia ya está abierta y lista para aceptar datos de salida de tipo caracter. "));      
        
        provider.addCompletion(new ShorthandCompletion(provider, "fori", "int i;\nfor(i=0; i < 10; i=i+1;){\n}", "Bucle for"));
        provider.addCompletion(new ShorthandCompletion(provider, "while", "while(true){\n}", "Bucle while"));

        
        return provider;

    }

}
