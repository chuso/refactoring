package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.controllers.PlayController;
import es.urjccode.mastercloudapps.adcs.draughts.models.Error;
import es.urjccode.mastercloudapps.adcs.draughts.models.Movement;
import es.urjccode.mastercloudapps.adcs.draughts.models.Coordinate;

class PlayView extends SubView {

    private static final String[] COLORS = {"blancas", "negras"};

    public PlayView(){
        super();
    }

    void interact(PlayController playController) {
        String color = PlayView.COLORS[playController.getColor().ordinal()];
        Error error = null;
        GameView gameView = new GameView();
        String promptString = MessageView.ANOUNCE_MOVE.getMessage().replaceFirst("#color", color);
        do {
            String command = this.console.readString(promptString);
            String[] numbers = command.split("\\.|\\s+");
            Movement movement = new Movement(new Coordinate(numbers[0]), new Coordinate(numbers[1]));
            error = playController.move(movement);
            if (error != null){
                console.writeln(MessageView.ERROR.getMessage().replaceFirst("#error", error.name()));
                gameView.write(playController);
            }
        } while (error != null); 
        if (playController.isBlocked()){
            MessageView.LOSE.write();
        }
    }

}