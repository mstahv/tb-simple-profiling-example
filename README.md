TestBench Profiling Example
===========================

TestBench 3 has simple methods that can be used to track processing time consumed by both the client side (aka browser) and server side during integration tests. This example, derived from TestBench package, shows how you can easily report these values during build process.

There is a project for both V6 and V7. You can run both from the project root with `mvn install` or either of them separately.

The example is overly simple, but should you a rough idea of what can be done. We only print metrics out to console, but developers could just as well make limits in which they expect their app to perform and then fail the build if performance numbers are too bad. New slow algorithms or sluggish sql queries should be easy to spot before deploying a new version to production.

Note, that this kind of testing will not obsolete proper application profiling. E.g. concurrency in server may change results dramatically. Also, to get more sophisticated numbers, it would be best to move both server and browsers to a separate hardware. That could be done for TestBench testing as well.

Lessons learned:
----------------
 * See how server execution times gets down during the tests. If you are measuring server side execution time, do enough "warm up" by example running the use case several times in a row. JVM is quite a beast to optimize stuff with its JIT compiler. You'll also eliminate the time used for class loading etc which is irrelevant in the long run.
 * V6 and V7 are very different beasts (or deers) and this also applies to performance(*). Same applies to upgrading other all software libraries. So especially on high volume public apps, measure performance characteristics of your application during development! TestBench is a cheap option (or complement) if you can't afford to a more throughout testing setup.
 * Automate tests to be part of your build process. Just like you probably do with your unit tests. Otherwise you'll forget them at a critical moment.

(*) Note, that V7 is still under active development and you can expect it to get much faster on both client and server side. It has already take big leaps during the autumn.