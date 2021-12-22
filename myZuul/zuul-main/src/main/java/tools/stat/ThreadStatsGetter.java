package tools.stat;

import tools.common.Stats;
import tools.common.StatsGetter;
import tools.common.ThreadStats;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;


public class ThreadStatsGetter implements StatsGetter {
    ThreadMXBean bean = ManagementFactory.getThreadMXBean();

    @Override
    public Stats get() {
        ThreadStats s = new ThreadStats();
        s.setCurrentThreadCount(bean.getThreadCount());
        s.setDaemonThreadCount(bean.getDaemonThreadCount());
        s.setBeenCreatedThreadCount(bean.getTotalStartedThreadCount());
        return s;
    }
}
