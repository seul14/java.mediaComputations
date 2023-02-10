import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Canvas here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Canvas extends World
{
    private static final String file = "dino.jpg";
    private static final GreenfootImage backg = new GreenfootImage(file); 
    /**
     * Constructor for objects of class Canvas.
     * 
     */
    public Canvas()
    {    
        super(1024, 768, 1); 
        reset();
    }

    public void reset()
    {
        setBackground(file);
    }

    public Color [][] getPixels()
    {
        // Creates a 2D Array of Colors that has Width x Height elements
        Color [][] clr = new Color [getHeight()][getWidth()];
        // Looping through the 2D Array
        for (int i = 0; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length; ++j)
            {
                // Stores the Color at each (j, i) in the corresponding slot in the 2D Array
                clr[i][j] = getColorAt(j, i);
            }
        }
        // Returns stored Color 2D Array
        return clr;
    }

    public void drawPixels(Color [][] pixel)
    {
        Color [][] clr = getPixels();
         GreenfootImage bg = getBackground(); // Creates a GreenfootImage with the dimensions of the array
        // Looping through the 2D Array
        for (int i = 0; i < pixel.length; ++i)
        {
            for (int j = 0; j < pixel[i].length; ++j)
            {
                bg.setColorAt(j, i, pixel[i][j]); // Sets at (j, i) in the image to the Color stored in the 2D Array.
            }
        }
    }

    public void randomizeOneColor()
    {
        Color [][] clr = getPixels();
        // Creates a random Color
        int r = (int)(Math.random() * 256);
        int g = (int)(Math.random() * 256);
        int b = (int)(Math.random() * 256);
        Color random = new Color (r, g, b);
        // Looping through the 2D Array
        for (int i = 0; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length; ++j)
            {
                clr[i][j] = random; // Stores 2D Array with random Color
            }
        }
        drawPixels(clr); // Runs drawPixels, sets each pixel to the Color corresponding to the 2D Array value
    }

    public void stacity()
    {
        Color [][] clr = getPixels(); 
        // Looping through the 2D Array
        for (int i = 0; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length; ++j)
            {
                // Creates a random Color inside the loop 
                int r = (int)(Math.random() * 256);
                int g = (int)(Math.random() * 256);
                int b = (int)(Math.random() * 256);
                Color random = new Color (r, g, b);
               
                clr[i][j] = random; // Stores 2D Array with random Color
            }
        }
        drawPixels(clr); // Runs drawPixels, sets each pixel to the Color corresponding to the 2D Array value
    }

    public void grayScale()
    {
        Color [][] clr = getPixels();
        for (int i = 0; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length; ++j)
            {
                Color c = getColorAt(j, i);
                int r = c.getRed();
                int g = c.getGreen();
                int b = c.getBlue();
                int gray = (r + g + b) / 3;
                Color scale = new Color (gray, gray, gray);
                clr[i][j] = scale;
            }
        }
        drawPixels(clr);
    }

    public void invert()
    {
        Color [][] clr = getPixels();
        for (int i = 0; i < clr.length; i++)
        {
            for (int j = 0; j < clr[i].length; j++)
            {
                Color c = getColorAt(j, i);
                int r = 255 - c.getRed();
                int g = 255 - c.getGreen();
                int b = 255 - c.getBlue();
                Color invert = new Color (r, g, b);
                clr[i][j] = invert;
            }
        }
        drawPixels(clr);
    }

    public void mirrorTopToBottom()
    {
        Color [][] clr = getPixels();
        for (int i = 0; i < clr.length; i++)
        {
            for (int j = 0; j < clr[i].length; j++)
            {
                clr[i][j] = getColorAt(j, i);
            }
        }
        for (int i = clr.length/2; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length; j++)
            {
                clr[i][j] = clr[clr.length - i - 1][j];
            }
        }
        drawPixels(clr);
    }

    public void mirrorBottomToTop()
    {
        Color [][] clr = getPixels();
        for (int i = 0; i < clr.length; i++)
        {
            for (int j = 0; j < clr[i].length; j++)
            {
                clr[i][j] = getColorAt(j, i);
            }
        }
        for (int i = 0; i < clr.length/2; i++)
        {
            for (int j = 0; j < clr[i].length; j++)
            {
                clr[i][j] = clr[clr.length - i - 1][j];
            }
        }
        drawPixels(clr);
    }

    public void mirrorLeftToRight()
    {
        Color [][] clr = getPixels();
        for (int i = 0; i < clr.length; i++)
        {
            for (int j = 0; j < clr[i].length; j++)
            {
                clr[i][j] = getColorAt(j, i);
            }
        }
        for (int i = 0; i < clr.length; i++)
        {
            for (int j = clr[i].length / 2; j < clr[i].length; j++)
            {
                clr[i][j] = clr[i][clr[i].length - j - 1];
            }
        }
        drawPixels(clr);
    }

    public void mirrorRightToLeft()
    {
        Color [][] clr = getPixels();
        for (int i = 0; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length; ++j)
            {
                clr[i][j] = getColorAt(j, i);
            }
        }
        for (int i = 0; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length / 2; ++j)
            {
                clr[i][j] = clr[i][clr[i].length - j - 1];
            }
        }
        drawPixels(clr);
    }

    public void flipHorizontal()
    {
        Color [][] clr = getPixels();
        Color [][] horizontal = new Color[clr.length][clr[0].length];
        for (int i = 0; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length; ++j)
            {
                horizontal[i][clr[i].length - j - 1] = clr[i][j];
            }
        }
        drawPixels(horizontal);
    }

    public void flipVertical()
    {
        Color [][] clr = getPixels();
        Color [][] vertical = new Color[clr.length][clr[0].length];
        for (int i = 0; i < clr.length; ++i)
        {
            for (int j = 0; j < clr[i].length; ++j)
            {
                vertical[clr.length - i - 1][j] = clr[i][j];
            }
        }
        drawPixels(vertical);
    }

    public void detectEdges(int threshold)
    {
        GreenfootImage bg= getBackground();
        Color [][] clr = getPixels();
        int firstR, firstG, firstB, secondR, secondG, secondB;
        for (int i = 0; i < clr.length - 1; ++i)
        {
            for (int j = 0; j < clr[i].length; ++j)
            {
                Color first = bg.getColorAt(j, i);
                firstR = first.getRed();
                firstG = first.getGreen();
                firstB = first.getBlue();

                // get the color of the pixel at (r, c+1)
                Color second = bg.getColorAt(j, i+1);
                secondR = second.getRed();
                secondG = second.getGreen();
                secondB = second.getBlue();

                // calculate the distance between the two colors
                double distance = Math.sqrt(Math.pow(firstR - secondR,2) + Math.pow(firstG - secondG,2) + Math.pow(firstB - secondB,2));

                // compare the distance against the threshold
                if(distance >= threshold)
                {
                    clr[i][j] = Color.WHITE;
                }
                else
                {
                    // otherwise, make the pixel black
                    clr[i][j] = Color.BLACK;
                }
            }
        }
        drawPixels(clr);
    }
}
