import java.awt.*;

public class CommonConstants {

    // ==== FRAME CONFIG ====
    public static final Dimension GUI_SIZE = new Dimension(500, 700);

    // ==== BANNER CONFIG ====
    public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width, 50);

    // ==== TASK PANEL CONFIG ====
    public static final Dimension TASK_PANEL_SIZE = new Dimension(GUI_SIZE.width - 30, GUI_SIZE.height - 175);

    // ==== ADD TASK BUTTON CONFIG ====
    public static final Dimension ADD_TASK_BUTTON_SIZE = new Dimension(GUI_SIZE.width, 50);

    // ==== TASK FIELD CONFIG ====
    public static final Dimension TASK_FIELD_SIZE = new Dimension((int)(TASK_PANEL_SIZE.width * 0.80),50);
    public static final Dimension CHECKBOX = new Dimension((int)(TASK_FIELD_SIZE.width * 0.05), 50);

    // ==== DELETE BUTTON ====
    public static final Dimension DELETE_BUTTON_SIZE = new Dimension((int)(TASK_FIELD_SIZE.width * 0.12), 50);


}
