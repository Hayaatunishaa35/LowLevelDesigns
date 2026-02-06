// package GoogleDocsLLD.BadDesign;
import java.io.FileWriter;
import java.util.*;

class DocumentEditor{
    private List<String> documentElements;
    private String renderedDocument;

    public DocumentEditor(){
        documentElements = new ArrayList<>();
        renderedDocument = "";
    }

    public void addText(String text){
        documentElements.add(text);
    }

    public void addImage(String imgURL){
        documentElements.add(imgURL);
    }

    public String renderDocument(){
        renderedDocument = "";

        StringBuilder result = new StringBuilder();

        for(String element: documentElements){
            if(element.length()>4 && (
                element.endsWith(".jpg") || element.endsWith(".png")
            )){
                result.append("[Image: ").append(element).append("]\n");
            }
            else{
                result.append(element).append("\n");
            }
        }


        renderedDocument = result.toString();
        return renderedDocument;
    }

    public void saveToFile(){
        try{
            FileWriter writer = new FileWriter("document.txt");
            writer.write(renderDocument());
            writer.close();
            System.out.println("Document saved to document.txt");
        }
        catch(Exception e){
            System.out.println("An error occured");
        }
    }
}

public class DocumentEditorClient {
    public static void main(String[] args){
        DocumentEditor editor = new DocumentEditor();
        editor.renderDocument();

        editor.addImage("Image Path 1");
        editor.addText("Text 1");
        editor.addImage("Image Path 2");
        editor.addText("Text 2");

        System.out.println(editor.renderDocument());
        editor.saveToFile();
    }
}
