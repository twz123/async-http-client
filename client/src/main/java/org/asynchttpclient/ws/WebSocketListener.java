/*
 * Copyright (c) 2010-2012 Sonatype, Inc. All rights reserved.
 *
 * This program is licensed to you under the Apache License Version 2.0,
 * and you may not use this file except in compliance with the Apache License Version 2.0.
 * You may obtain a copy of the Apache License Version 2.0 at http://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the Apache License Version 2.0 is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the Apache License Version 2.0 for the specific language governing permissions and limitations there under.
 */
package org.asynchttpclient.ws;

/**
 * A generic {@link WebSocketListener} for WebSocket events. Use the appropriate listener for receiving message bytes.
 */
public interface WebSocketListener {

    /**
     * Invoked when the {@link WebSocket} is open.
     *
     * @param websocket the WebSocket
     */
    void onOpen(WebSocket websocket);

    /**
     * Invoked when the {@link WebSocket} is close.
     * 
     * @see "http://tools.ietf.org/html/rfc6455#section-5.5.1"
     *
     * @param websocket the WebSocket
     * @param code the status code
     * @param reason the reason message
     */
    void onClose(WebSocket websocket, int code, String reason);

    /**
     * Invoked when the {@link WebSocket} is open.
     *
     * @param t a {@link Throwable}
     */
    void onError(Throwable t);

    /**
     * Invoked when bytes are available.
     * 
     * @param payload a byte array
     * @param finalFragment true if this frame is the final fragment
     * @param rsv extension bits
     */
    default void onBinaryFrame(byte[] payload, boolean finalFragment, int rsv) {
    };

    /**
     * Invoked when WebSocket text message are received.
     * 
     * @param payload a UTF-8 {@link String} message
     * @param finalFragment true if this frame is the final fragment
     * @param rsv extension bits
     */
    default void onTextFrame(String payload, boolean finalFragment, int rsv) {
    };

    /**
     * Invoked when a ping message is received
     * 
     * @param payload a byte array
     */
    default void onPingFrame(byte[] payload) {
    };

    /**
     * Invoked when a pong message is received
     * 
     * @param payload a byte array
     */
    default void onPongFrame(byte[] payload) {
    };
}
