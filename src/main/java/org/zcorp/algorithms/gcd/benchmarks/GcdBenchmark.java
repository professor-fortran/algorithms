package org.zcorp.algorithms.gcd.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.zcorp.algorithms.gcd.BruteForceGcd;
import org.zcorp.algorithms.gcd.EuclidLoopGcd;
import org.zcorp.algorithms.gcd.EuclidRecursionGcd;
import org.zcorp.algorithms.gcd.SchoolGcd;

import java.util.concurrent.TimeUnit;

@Warmup(iterations = 5)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.SingleShotTime)
@Fork(1)
@Threads(1)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Timeout(time = 5, timeUnit = TimeUnit.MINUTES)
@State(Scope.Benchmark)
public class GcdBenchmark {

    @Param({"31415"})
    private int m;

    @Param({"14142"})
    private int n;

    private SchoolGcd.Auxiliary auxiliary;

    @Setup
    public void setup() {
        auxiliary = new SchoolGcd.Auxiliary(m, n);
    }

    @Benchmark
    public double schoolGcd() {
        return auxiliary.gcd();
    }

    @Benchmark
    public double schoolGcdWithPrimesCreation() {
        return new SchoolGcd().gcd(m, n);
    }

    @Benchmark
    public double euclidLoopGcd() {
        return new EuclidLoopGcd().gcd(m, n);
    }

    @Benchmark
    public double euclidRecursionGcd() {
        return new EuclidRecursionGcd().gcd(m, n);
    }

    @Benchmark
    public double bruteForceGcd() {
        return new BruteForceGcd().gcd(m, n);
    }

}
