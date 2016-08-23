/*
 * This class is part of the book "iText in Action - 2nd Edition"
 * written by Bruno Lowagie (ISBN: 9781935182610)
 * For more info, go to: http://itextpdf.com/examples/
 * This example only works with the AGPL version of iText.
 */

package classi;

import com.itextpdf.text.BaseColor;
import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import javafx.scene.paint.Color;


/**
 * First iText example: Hello World.
 */
public class Pdf {
private String[][] elementi;
private String codice;
private String data;
private String nome;
private String indirizzo;
private String piva;
private String imponibile;
private String impostaIva;
private String totaleFattura;
    /** Path to the resulting PDF file. */
    
    
    /**
     * Creates a PDF file: hello.pdf
     * @param    args    no arguments needed
     */


    /**
     * Creates a PDF document.
     * @param filename the path to the new PDF document
     * @throws    DocumentException 
     * @throws    IOException 
     */
    public void createPdf(String filename,String[][] elementi,String codice,String data,String nome,String indirizzo,String piva,String imponibile,String impostaIva,String totaleFattura)
	throws DocumentException, IOException {
        this.elementi=elementi;
        this.codice=codice;
        this.data=data;
        this.nome=nome;
        this.piva=piva;
        this.indirizzo=indirizzo;
        this.imponibile=imponibile;
        this.totaleFattura=totaleFattura;
        this.impostaIva=impostaIva;
        
        
            // step 1
            Document document = new Document();
            // step 2
            PdfWriter.getInstance(document, new FileOutputStream(filename));

            // step 3
            document.open();
            // step 4

            document.add(getLinea1());
            document.add(getTitolo());
            document.add(getSottotitolo());
            document.add(getLinea2());
            document.add(getDataCodice());
            document.add(getInfoCliente());
            document.add(createFirstTable());
            document.add(getInfoTotale());
            // step 5
            document.close();
        
        
    }
    
    public  Paragraph getTitolo(){
        Paragraph titolo = new Paragraph("AZIENDA AGRICOLA PROVA PROVA");
        titolo.setAlignment(Element.ALIGN_CENTER);
        return titolo;
    
    }
    
    public  Paragraph getDataCodice(){
        float fntSize, lineSpacing;
            fntSize = 9.7f;
            lineSpacing = 10f;
           
        Paragraph codiceData =  new Paragraph(new Phrase(lineSpacing,"Fattura "+codice+" del "+ data,FontFactory.getFont(FontFactory.TIMES_BOLD, fntSize)));
        codiceData.setAlignment(Element.ALIGN_LEFT);
        codiceData.setIndentationLeft(29);
        codiceData.setSpacingAfter(10);
        return codiceData;
    
    }
    
    public Paragraph getLinea1(){
        Paragraph linea1=new Paragraph("______________________________________________________________________");
        linea1.setAlignment(Element.ALIGN_CENTER);
        return linea1;
    }
     public Paragraph getLinea2(){
        Paragraph linea2=new Paragraph("______________________________________________________________________");
        linea2.setSpacingAfter(40);
        linea2.setAlignment(Element.ALIGN_CENTER);
        return linea2;
    }
    
     public  Paragraph getSottotitolo(){
      float fntSize, lineSpacing;
            fntSize = 8.7f;
            lineSpacing = 10f;
            Paragraph sottoTitolo = new Paragraph(new Phrase(lineSpacing,"VIA PROVA 900 NOLA(NA) C.F PPPPPPPPPPPPPPPP P.IVA 000000000000000",FontFactory.getFont(FontFactory.TIMES, fntSize)));
            sottoTitolo .setAlignment(Element.ALIGN_CENTER);
            return sottoTitolo;
     }
     
       public  Paragraph getInfoCliente(){
      float fntSize, lineSpacing;
            fntSize = 8.7f;
            lineSpacing = 10f;
            Paragraph sottoTitolo = new Paragraph(new Phrase(lineSpacing,nome+"\n"+ indirizzo +"\n"+" P.Iva:"+piva,FontFactory.getFont(FontFactory.TIMES_BOLD, fntSize)));
            sottoTitolo.setIndentationRight(29);
            sottoTitolo .setAlignment(Element.ALIGN_RIGHT);
            sottoTitolo.setSpacingAfter(30);
            return sottoTitolo;
     }
       
       
          public  Paragraph getInfoTotale(){
            float fntSize, lineSpacing;
            fntSize = 9.7f;
            lineSpacing = 10f;
            
            Paragraph sottoTitolo = new Paragraph(new Phrase(lineSpacing,"Imponibile:"+imponibile+"\n \n Imposta Iva:"+ impostaIva +"\n \n"+" Totale Fattura:"+totaleFattura,FontFactory.getFont(FontFactory.TIMES_BOLD, fntSize)));
            sottoTitolo.setIndentationRight(29);
            sottoTitolo .setAlignment(Element.ALIGN_RIGHT);
            sottoTitolo.setSpacingBefore(30);
            return sottoTitolo;
     }
      public  PdfPTable createFirstTable() {
    	// a table with three columns
        PdfPTable table = new PdfPTable(8);
        table.setWidthPercentage(90);
       
        // the cell object
        Phrase descrizione=new Phrase("Descrizione");
        Font normalFont = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
        descrizione.setFont(normalFont);
        PdfPCell pdfWordCell = new PdfPCell();
        pdfWordCell.addElement(descrizione);
        PdfPCell cell = new PdfPCell(pdfWordCell);
        cell.setBackgroundColor(BaseColor.CYAN);
       
        cell.setColspan(3);
        Phrase qnt=new Phrase("Quantita");
        qnt.setFont(normalFont);
        pdfWordCell = new PdfPCell();
        pdfWordCell.addElement(qnt);
        PdfPCell cell1 = new PdfPCell(pdfWordCell);
        cell1.setBackgroundColor(BaseColor.CYAN);
        
        cell1.setPaddingBottom(10);
        Phrase prezzoUnitario=new Phrase("Prezzo Unitario");
        prezzoUnitario.setFont(normalFont);
        pdfWordCell = new PdfPCell();
        pdfWordCell.addElement(prezzoUnitario);
        PdfPCell cell2 = new PdfPCell( pdfWordCell);
        
        cell2.setBackgroundColor(BaseColor.CYAN);
    
        cell2.setColspan(2);
        Phrase importo=new Phrase("Importo");
        importo.setFont(normalFont);
        pdfWordCell = new PdfPCell();
        pdfWordCell.addElement(importo);
        PdfPCell cell3 = new PdfPCell(pdfWordCell);
        cell3.setBackgroundColor(BaseColor.CYAN);
        cell3.setPaddingTop(2);
        Phrase iva=new Phrase("iva");
        iva.setFont(normalFont);
        pdfWordCell = new PdfPCell();
        pdfWordCell.addElement(iva);
        PdfPCell cell4 = new PdfPCell( pdfWordCell);
        cell4.setBackgroundColor(BaseColor.CYAN);
        
        // we add a cell with colspan 3
        
 
        // now we add a cell with rowspan 2

  
        // we add the four remaining cells with addCell()
     
        table.addCell(cell);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        table.addCell(cell4);
        
        for(int i=0;i<this.elementi.length;i++){
            Font normalFont1 = new Font(Font.FontFamily.TIMES_ROMAN, 10, Font.ITALIC);
            Phrase des=new Phrase(elementi[i][0]);
            pdfWordCell = new PdfPCell();
            des.setFont(normalFont1);
            pdfWordCell.addElement(des);
            PdfPCell cellDescrizione= new PdfPCell(pdfWordCell);
            
            cellDescrizione.setPaddingTop(2);
            cellDescrizione.setColspan(3);
            Phrase quantita=new Phrase(elementi[i][1] +" "+elementi[i][2]);
            pdfWordCell = new PdfPCell();
            quantita.setFont(normalFont1);
            pdfWordCell.addElement(quantita);
            PdfPCell cellQuantita= new PdfPCell(pdfWordCell);
            
            Phrase prezzoU=new Phrase(elementi[i][3]);
            pdfWordCell = new PdfPCell();
            prezzoU.setFont(normalFont1);
            pdfWordCell.addElement(prezzoU);
            PdfPCell cellPrezzoUnitario= new PdfPCell(pdfWordCell);
            cellPrezzoUnitario.setPaddingTop(2);
            cellPrezzoUnitario.setColspan(2);
            
            
            Phrase impor=new Phrase(elementi[i][4]);
            pdfWordCell = new PdfPCell();
            impor.setFont(normalFont1);
            pdfWordCell.addElement(impor);
            PdfPCell cellImporto= new PdfPCell(pdfWordCell);

            Phrase iv=new Phrase(elementi[i][5]);
            pdfWordCell = new PdfPCell();
            iv.setFont(normalFont1);
            pdfWordCell.addElement(iv);
            PdfPCell cellIva= new PdfPCell(pdfWordCell);
            
             table.addCell(cellDescrizione);
             table.addCell(cellQuantita);
             table.addCell(cellPrezzoUnitario);
             
             table.addCell(cellImporto);
             table.addCell(cellIva);
        }
        
        
        
        
        

        return table;
    }
}
