

import java.util.ArrayList;
import java.util.List;


// contract for persistence
interface Persistence{
    void save(String data);
}

// Storage in the file system
class FileStorage implements Persistence{
    @Override
    public void save(String data){
        try{
            System.out.println("Data Saved to File");
        }
        catch(Exception e){
            System.out.println("An error occured during FileStorage operations");
            e.printStackTrace();
        }
    }
}

// Storage in the DB
class DBStorage implements Persistence{
    @Override
    public void save(String data){
        try{
            System.out.println("Data saved to DB");
        }
        catch(Exception e){
            System.out.println("An error occured during DBStorage operations");
            e.printStackTrace();
        }
    }
}

// Interface for document element
interface DocumentElement{
    String render();
}

// Document element of type text
class TextElement implements DocumentElement{
    private String text;

    public TextElement(String text){
        this.text = text;
    }

    @Override
    public String render(){
        return this.text;
    }
}

// Document element of type image
class ImageElement implements DocumentElement{
    private String imgURL;

    public ImageElement(String imgURL){
        this.imgURL = imgURL;
    }

    @Override
    public String render(){
        return this.imgURL;
    }
}

// Document consisting different document elements and render method
class Document{
    private List<DocumentElement> documentElements = new ArrayList<>();

    public void addElement(DocumentElement element){
        documentElements.add(element);
    }

    public String render(){
        StringBuilder result = new StringBuilder();

        for(DocumentElement element: documentElements){
            result.append(element).append("\n");
        }

        return result.toString();
    }
}


// The final document editor communicating directly with the client and other component of the application (Acting as a layer)
class DocumentEditor{
    private Document document;
    private Persistence storage;
    private String renderedDocument;

    public DocumentEditor(Document document, Persistence storage){
        this.document = document;
        this.storage = storage;
        renderedDocument = "";
    }

    public void addText(String text){
        document.addElement(new TextElement(text));
    }

    public void addImage(String imgURL){
        document.addElement(new ImageElement(imgURL));
    }

    public String renderDocument(){
        renderedDocument = document.render();
        return renderedDocument;
    }

    public void saveData(){
        storage.save(renderedDocument);
    }

}

public class DocumentEditorClient {
    public static void main(String[] args){
        Document document = new Document();
        Persistence storage = new FileStorage();
        DocumentEditor documentEditor = new DocumentEditor(document, storage);

        documentEditor.addImage("Image 1 URL");
        documentEditor.addText("Text 1");
        documentEditor.addImage("Image 2 URL");
        documentEditor.addText("Text 2");

        System.out.println(documentEditor.renderDocument());

        documentEditor.saveData();
    }    
}
