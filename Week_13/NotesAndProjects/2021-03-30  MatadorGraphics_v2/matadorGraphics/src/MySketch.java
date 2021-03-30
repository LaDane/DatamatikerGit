import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PShape;
import processing.core.PVector;

public class MySketch extends PApplet {

    private PVector centerPoint = new PVector(400,400);
    private PShape displayFieldSquare;
    private PShape displayFieldDivider;

    public void settings() {
        size(800,800);
    }

    public void setup() {
        background(0x526e1a);                                                        // green Background
        // textFont(createFont("andalemo.ttf", 16,true));              // create & set font
    }

    public void draw() {
        translate(400,400);             // change
        rotate(radians(-9));

        createBoard();

        int iteration = 1;
        for (int i = 0; i < 360; i += 9) {
            rotate(radians(9));

            shape(displayFieldSquare);
            shape(displayFieldDivider);

            displayFieldNumber(iteration);
            iteration++;
        }
    }


    public void createBoard() {
        createFieldSquare();
        displayFieldSquare.setFill(color(173, 216, 230));
        displayFieldSquare.setStrokeWeight(3);

        createFieldDivider();
        displayFieldDivider.setFill(100);
        displayFieldDivider.setStrokeWeight(3);
    }

    public void createFieldSquare() {
        displayFieldSquare = createShape();
        displayFieldSquare.beginShape();

        displayFieldSquare.vertex(16,220);
        displayFieldSquare.vertex(-16,220);
        displayFieldSquare.vertex(-30,390);
        displayFieldSquare.vertex(0,391);
        displayFieldSquare.vertex(30,390);

        displayFieldSquare.endShape();
    }

    public void createFieldDivider() {
        displayFieldDivider = createShape();
        displayFieldDivider.beginShape();

        displayFieldDivider.vertex(27,350);
        displayFieldDivider.vertex(-27,350);

        displayFieldDivider.endShape();
    }

    public void displayFieldNumber(int numberToDisplay) {
        textAlign(CENTER, CENTER);
        text(numberToDisplay, 0, 205);
    }
}
