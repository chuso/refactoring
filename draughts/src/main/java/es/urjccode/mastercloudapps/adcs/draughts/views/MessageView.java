package es.urjccode.mastercloudapps.adcs.draughts.views;

import es.urjccode.mastercloudapps.adcs.draughts.utils.Console;

enum MessageView {

    TITLE("Draughts"),
    LOSE("Derrota!!! No puedes mover tus fichas!!!");

    private String message;

    private static Console console = new Console();

    private MessageView(String message) {
        this.message = message;
    }

    void write() {
        MessageView.console.write(this.message);
    }

    void writeln() {
        MessageView.console.write(this.message);
    }
}
