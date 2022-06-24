/* 
 * Name: 0b2b215d3895dc070ff308ca5d5733bb0abda40f
 * PennKey: 0b2b215d3895dc070ff308ca5d5733bb0abda40f
 * 
 * Execution: java MySketch
 */

public class MySketch {
    public static void main(String[] args) {
        PennDraw.setCanvasSize(500, 500);
        
        //draw the sky
        PennDraw.clear(PennDraw.BOOK_LIGHT_BLUE);
        
        //draw a road
        PennDraw.setPenColor(128, 144, 163);
        PennDraw.filledRectangle(0.5, 0.0, 0.5, 0.3);
        
        //change pen color to black 
        PennDraw.setPenColor();
        
        //change pen width
        PennDraw.setPenRadius(.010);
       
        //draw front wheel 
        PennDraw.circle(.3, .3, .1);
        
        //draw back wheel
        PennDraw.circle(.7, .3, .1);
        
        //draw front bar
        PennDraw.line(.3, .3, .4, .55);
        
        //draw front wheel center
        PennDraw.circle(.3, .3, .007);
        
        //draw back wheel center
        PennDraw.circle(.7, .3, .007);
        
        //draw top bar
        PennDraw.line(.38, .5, .62, .5);
        
        //draw back bar
        PennDraw.line(.62, .5, .7, .3);
        
        //draw middle bar 1
        PennDraw.line(.38, .5, .5, .3);
        
        //draw middle bar 2
        PennDraw.line(.65, .55, .5, .3);
        
        //draw bottom bar
        PennDraw.line(.5, .3, .7, .3);
        
        //draw pedal
        PennDraw.filledCircle(.5, .3, .032);    
        
        //draw seat
        PennDraw.filledPie(.64, .53, .04, 0, 180);
        
        //draw bottom of handlebars
        PennDraw.line(.36, .55, .4, .55);
        
        //draw middle of handlebars
        PennDraw.line(.36, .55, .36, .58);
        
        //draw top of handlebars
        PennDraw.line(.36, .58, .43, .58);
        
        //change pen color to yellow
        PennDraw.setPenColor(PennDraw.YELLOW);
        
        //draw line 1 on road
        PennDraw.filledRectangle(.15, .15, .09, .02);
        
        //draw line 2 on road
        PennDraw.filledRectangle(.5, .15, .09, .02);
        
        //draw line 3 on road
        PennDraw.filledRectangle(.85, .15, .09, .02);
        
        //draw a sun
        PennDraw.filledCircle(.05, .95, .18);
        
    }
}