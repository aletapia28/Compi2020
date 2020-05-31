package htmlWriter;

import java.io.FileWriter;
import java.io.IOException;


import Triangle.AbstractSyntaxTrees.Program;

public class HtmlWriter {
	private String fileName;

    public HtmlWriter(String fileName) {
        this.fileName = fileName.replace(".tri", ".html");
    }

    // Draw the AST representing a complete program.
    //public void write(Program ast) {
    public void write(String data) {
        // Prepare the file to write
        try {
            FileWriter fileWriter = new FileWriter(fileName);

            //HTML header
            fileWriter.write("<html><body>"+data+"</body></html>");

            //WriterVisitor layout = new WriterVisitor(fileWriter);
            //ast.visit(layout, null);

            fileWriter.close();

        } catch (IOException e) {
            System.err.println("Error while creating file for print the AST");
            e.printStackTrace();
        }
    }
}