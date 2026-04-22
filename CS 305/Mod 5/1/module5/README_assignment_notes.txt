CS 305 Module Five - Checksum Verification

Changes completed:
1. Updated ServerApplication.java to generate a SHA-256 checksum.
2. Added the unique data string: Baj Sidhu.
3. Added bytesToHex conversion and returned the algorithm name and checksum at /hash.
4. Fixed the test package name so it matches the application package.

Expected browser route:
https://localhost:8443/hash

Expected checksum for 'Baj Sidhu':
538ad1c07c4afedb2465f64ad9fc7539d6fcbe75c93cd2d4ebb0cbf149b195ed

Note:
The Maven wrapper could not be fully executed in this container because it needs to download
dependencies from repo.maven.apache.org, and internet access is disabled here.
