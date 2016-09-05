package c.org.rajawali3d.scene.graph;

import android.support.annotation.Nullable;
import c.org.rajawali3d.annotations.RequiresWriteLock;

import java.util.concurrent.locks.Lock;

/**
 * @author Jared Woolston (Jared.Woolston@gmail.com)
 */
interface NodeParent {

    /**
     * Acquires a write lock for the scene graph. This method will block until a lock is acquired. Code using this
     * block must be properly protected with a {@code try-finally} block to ensure that the lock is released even in
     * the event of exceptions. Client code should avoid using this method or risk thread safety problems.
     *
     * @return The {@link Lock} which was acquired so that utilizing code may later release it.
     * @throws InterruptedException Thrown if the calling thread was interrupted while waiting for lock acquisition.
     */
    @Nullable Lock acquireWriteLock() throws InterruptedException;

    /**
     * Acquires a read lock for the scene graph. This method will block until a lock is acquired. Code using this
     * block must be properly protected with a {@code try-finally} block to ensure that the lock is released even in
     * the event of exceptions. Client code should avoid using this method or risk thread safety problems.
     *
     * @return The {@link Lock} which was acquired so that utilizing code may later release it.
     * @throws InterruptedException Thrown if the calling thread was interrupted while waiting for lock acquisition.
     */
    @Nullable Lock acquireReadLock() throws InterruptedException;

    /**
     * Initiates a restructure of the scene graph to accommodate any changes made due to transformations. It is
     * assumed that a write lock on the scene graph is held at this point acquired via the
     * {@link #acquireWriteLock()} method. Client code should avoid using this method or risk thread safety problems.
     */
    @RequiresWriteLock void updateGraph();
}