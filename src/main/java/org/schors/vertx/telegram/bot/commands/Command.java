/*
 *
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2016 schors
 *   Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 */

package org.schors.vertx.telegram.bot.commands;

import org.schors.vertx.telegram.bot.TelegramBot;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Command {

    private TelegramBot bot;
    private Pattern pattern;

    public Command(String regexp) {
        this.pattern = Pattern.compile(regexp);
    }

    public boolean isApplicable(String text) {
        Matcher m = pattern.matcher(text);
        return m.matches();
    }

    protected TelegramBot getBot() {
        return this.bot;
    }

    public void setBot(TelegramBot bot) {
        this.bot = bot;
    }

    public abstract void execute(String text, CommandContext context);
}