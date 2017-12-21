package com.github.drxaos.sandboxed;

import com.google.monitoring.runtime.instrumentation.AllocationRecorder;
import com.google.monitoring.runtime.instrumentation.Sampler;

import java.util.WeakHashMap;

public class Loader {
    public static void main(String[] args) {
        AllocationRecorder.addSampler(new Sampler() {
            WeakHashMap<Object, Long> objs = new WeakHashMap<Object, Long>();

            public void sampleAllocation(int count, String desc, Object newObj, long size) {
                objs.put(newObj, size);

                long full = 0;
                for (Long s : objs.values()) {
                    full += s;
                }
                System.out.println(full);
            }
        });

        Example.main(null);
    }
}
