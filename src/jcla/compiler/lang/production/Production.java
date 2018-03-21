/**
 * Copyright (c) 2018 Andrew Porter.
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following
 * conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 * <p>
 * This file is part of JCLassAssistant
 * <p>
 * Created on 3/13/2018 at 7:06 PM
 */

package jcla.compiler.lang.production;

import jcla.compiler.lang.production.token.Token;

import java.lang.invoke.MethodHandle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrew Porter
 */
public abstract class Production {

    protected final List<Production> components;

    public Production(List<Production> components) {
        this.components = components;
    }

    public List<Production> getComponents() {
        return components;
    }

    public List<Token> asTokens() {
        List<Token> tokens = new ArrayList<>(components.size());

        for(Production production : components) {
            tokens.addAll(production.asTokens());
        }

        return tokens;
    }

    public boolean isConcrete() {
        return false;
    }

    public String getSymbol() {
        return null;
    }

}
