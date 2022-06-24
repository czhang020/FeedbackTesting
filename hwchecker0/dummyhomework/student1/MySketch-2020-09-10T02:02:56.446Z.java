// Name: 5bd06d8ef939a24e4be9a8a295565db039cfb173
// pennkey: 5bd06d8ef939a24e4be9a8a295565db039cfb173

public class MySketch {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(500,500);

        // draw pink background
        PennDraw.clear(PennDraw.PINK);
        
        //draw orange rectangle
        PennDraw.setPenColor(PennDraw.ORANGE);
        PennDraw.filledRectangle(250.0/500,260.0/500,120.0/500, 90.0/500);
        
        // draw orange circle
        PennDraw.filledCircle(.25,.75,.15);
        
        // draw two orange triangles
        PennDraw.filledPolygon(0.15,0.95,0.16,0.97,0.15,0.95);
        
        
        
        
        
        
    }
}