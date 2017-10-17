package com.hotel.controller.command;

import com.hotel.controller.command.implementation.*;

public class CommandFactory {
    public CommandFactory() {
    }

    /**
     * getCommand for servlet
     * @param command
     * @return
     */
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
                case "sendCheck":
                    return new CheckSendCommand();
                case "noFreeRoom":
                    return new NoFreeRoomCommand();
                case "logout":
                    return new LogoutCommand();
                default:
                    return null;
            }
        }
        return null;
    }
}
