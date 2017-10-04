package com.epamhotel.controller.command;

import com.epamhotel.controller.command.implementation.*;

public class CommandFactory {
    public CommandFactory() {
    }

    public static AbstractCommand getCommand(String command) {
        if(command != null) {
            switch (command) {
                case "start":
                    return new StartPageCommand();
                case "toLogin":
                    return new LoginPageCommand();
                case "login":
                    return new LoginCommand();
                case "request":
                    return new RequestCommand();
                case "sendRequest":
                    return new SendRequestCommand();
                case "error":
                    return new ErrorCommand();
                case "getOpenRequests":
                    return new OpenRequestsCommand();
                case "adminMenu":
                    return new ToAdminMenuCommand();
                case "checkRoomExistence":
                    return new RoomExistenceCommand();
                default:
                    return null;
            }
        }
        return null;
    }
}
