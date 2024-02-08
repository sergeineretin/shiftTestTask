# shiftTestTask
This program is a test case for the SHIFT project. shiftTestTask is a utility for filtering file contents.

### Usage
This utility may have the following options:

- The **-o** option allows you to specify the path to the file with the results.
- The **-p** option specifies the prefix of output file names.
- Selection of statistics is done with the options **-s** and **-f**. 

The summary statistics contain only
  the number of items written to the outgoing files. Full statistics for numbers
  additionally contains minimum and maximum values, sum and average.
  Full statistics for strings, in addition to their number, also contains the size of the shortest string and the longest string.
  shortest line and the longest line.

### Build and run
The version of **java** used in this application is `Java 17`.

The standard **Gradle** project build system was used for assembly. The version of **Gradle** is `gradle-8.2`.

An example of running the utility might be as follows:
```bash
/path/to/java -jar shiftTestTask-0.1.0-dev.jar -s file.txt -p sample_dir- file2.txt -o \dir
```

### License
[MIT](LICENSE)