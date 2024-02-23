package br.eduprivate.netty;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ChatServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
        // Handle a new client connection
        System.out.println("New client connected: " + ctx.channel().remoteAddress());
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        // Handle incoming messages
        String message = (String) msg;
        System.out.println("Received message: " + message);

        // Broadcast the message to all connected clients
        // Implement logic to send messages to clients here
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Handle exceptions
        cause.printStackTrace();
        ctx.close();
    }
}
