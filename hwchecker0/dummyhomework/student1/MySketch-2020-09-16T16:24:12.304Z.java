/**
* Name : 0c51503c95c50eeaf97615b29561f75e0d6d60c3
* PennKey : 0c51503c95c50eeaf97615b29561f75e0d6d60c3
*
* Execution :
*
* This draws a house in the middle of a field with a blue sky
*
*
*/

public class MySketch {
    
    public static void main(String[] args) {
        
        PennDraw.setCanvasSize(510, 510);
        
        PennDraw.clear(22, 155, 98);
        PennDraw.filledRectangle(0.5, 0.75, 0.2, 0.25);
   
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.filledRectangle(0.5, 0.75, 0.2, 0.25);
        
        PennDraw.setPenColor(PennDraw.ORANGE);
        PennDraw.filledRectangle(0.85, 0.75, 0.2, 0.25);
        
        PennDraw.setPenColor(PennDraw.WHITE);
        PennDraw.filledRectangle(0.5, 0.25, 0.5, 0.25);
        
        PennDraw.setPenColor(PennDraw.RED);
        PennDraw.filledRectangle(0.5, 0.25, 0.05, 0.25);
        PennDraw.filledRectangle(0.5, 0.25, 0.5, 0.05);
        
    }
}