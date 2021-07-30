package com.kolon.recyclerviewpagination.log;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

public class TimberLog extends Timber.DebugTree{
    @Override
    protected @Nullable String createStackElementTag(@NotNull StackTraceElement element) {
        return element.getFileName() + " :: " + element.getLineNumber() + " :: " + element.getMethodName();
    }
}
