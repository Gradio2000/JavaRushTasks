package com.javarush.task.task32.task3209;


import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller {
    private View view;
    private HTMLDocument document;
    private File currentFile;

    public Controller(View view) {
        this.view = view;
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void init(){
        createNewDocument();
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void exit(){
        System.exit(0);
    }

    public void resetDocument(){
        if (document != null){
            document.removeUndoableEditListener(view.getUndoListener());
        }
        document = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
        document.addUndoableEditListener(view.getUndoListener());
        view.update();
    }

    public void setPlainText(String text){
        resetDocument();
        StringReader reader = new StringReader(text);
        try {
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(reader, document, 0);
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
    }

    public String getPlainText(){
        StringWriter stringWriter = new StringWriter();
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab();
        resetDocument();
        view.setTitle("HTML редактор");
        view.resetUndo();
        currentFile = null;
    }

    public void openDocument() {
        view.selectHtmlTab();

        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());

        if (chooser.showOpenDialog(view) == chooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());
            resetDocument();
            try {
                FileReader fileReader = new FileReader(currentFile);
                new HTMLEditorKit().read(fileReader, document, 0);
                view.resetUndo();
                fileReader.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }

    }

    public void saveDocument() {
        view.selectHtmlTab();

        if (currentFile != null) {
            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
                writer.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
        else {
            saveDocumentAs();
        }
    }


    public void saveDocumentAs() {
        view.selectHtmlTab();
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new HTMLFileFilter());
        
        if (chooser.showSaveDialog(view) == chooser.APPROVE_OPTION) {
            currentFile = chooser.getSelectedFile();
            view.setTitle(currentFile.getName());


            try {
                FileWriter writer = new FileWriter(currentFile);
                new HTMLEditorKit().write(writer, document, 0, document.getLength());
                writer.close();
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
