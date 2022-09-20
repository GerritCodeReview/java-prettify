java_library(
    name = "java-prettify",
    srcs = glob(["src/**/*.java"]),
    resources = [
        "src/prettify/example/example.html",
    ],
    visibility = ["//visibility:public"],
)

java_binary(
    name = "java-prettify-example",
    main_class = "prettify.example.Example",
    runtime_deps = [":java-prettify"],
)
