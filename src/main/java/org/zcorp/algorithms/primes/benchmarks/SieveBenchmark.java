package org.zcorp.algorithms.primes.benchmarks;

import org.openjdk.jmh.annotations.*;
import org.zcorp.algorithms.primes.EratosthenesSieve;
import org.zcorp.algorithms.primes.FortranSieve;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Warmup(iterations = 5)
@Measurement(iterations = 5)
@BenchmarkMode(Mode.SingleShotTime)
@Fork(1)
@Threads(1)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Timeout(time = 5, timeUnit = TimeUnit.MINUTES)
@State(Scope.Benchmark)
public class SieveBenchmark {

    @Param({"100", "1000", "10000", "100000"})
    private int n;

    @Benchmark
    public List<Integer> fortranSieve() {
        return new FortranSieve().sieve(n);
    }

    @Benchmark
    public List<Integer> eratosthenesSieve() {
        return new EratosthenesSieve().sieve(n);
    }

}
