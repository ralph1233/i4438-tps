#!/bin/bash

Name="tp4-ex2"

cd "tp4/ex2" || exit

SESSION_FOLDER="."
OUTPUT_TEXT="all_contents.txt"

> "$OUTPUT_TEXT"

# Add CSS styling with background colors for different file types
echo "<style>
  .file-header {
    color: white;
    padding: 8px 12px;
    border-radius: 4px;
    margin: 20px 0 10px 0;
    font-family: Arial, sans-serif;
    font-weight: bold;
  }
  .java-header {
    background-color: #4CAF50; /* Green */
    border-left: 4px solid #2E7D32;
  }
  .xml-header {
    background-color: #2196F3; /* Blue */
    border-left: 4px solid #0D47A1;
  }
  .code-block {
    background-color: #f8f8f8;
    border: 1px solid #ddd;
    border-radius: 3px;
    padding: 12px;
    margin-bottom: 20px;
    overflow-x: auto;
  }
  .divider {
    border-top: 1px dashed #ccc;
    margin: 25px 0;
  }
  pre {
    font-family: Courier New, monospace;
    font-size: 10pt;
    color: #000000;
    margin: 0;
    white-space: pre-wrap;
  }
</style>" >> "$OUTPUT_TEXT"

for dir in "$SESSION_FOLDER"/; do
  echo "Processing directory: $dir"
  
  echo "<h2>📁 Contents of $dir</h2>" >> "$OUTPUT_TEXT"
  
  # Process Java files with green header
  if [ -d "${dir}java" ]; then
    find "${dir}java" -type f ! -name 'AndroidManifest.xml' -exec sh -c '
      echo "<div class=\"file-header java-header\">📝 Java File: $1</div>" >> "$2"
      echo "<div class=\"code-block\"><pre>" >> "$2"
      cat "$1" | sed -e "s/&/\\&amp;/g" -e "s/</\\&lt;/g" -e "s/>/\\&gt;/g" >> "$2"
      echo "</pre></div>" >> "$2"
      echo "<div class=\"divider\"></div>" >> "$2"
    ' sh {} "$OUTPUT_TEXT" \;
  fi
  
  # Process XML files with blue header
  if [ -d "${dir}xml" ]; then
    find "${dir}xml" -type f ! -name 'AndroidManifest.xml' -exec sh -c '
      echo "<div class=\"file-header xml-header\">📋 XML File: $1</div>" >> "$2"
      echo "<div class=\"code-block\"><pre>" >> "$2"
      sed -e "s/&/\\&amp;/g" -e "s/</\\&lt;/g" -e "s/>/\\&gt;/g" "$1" >> "$2"
      echo "</pre></div>" >> "$2"
      echo "<div class=\"divider\"></div>" >> "$2"
    ' sh {} "$OUTPUT_TEXT" \;
  fi
done

# Convert with additional document formatting
pandoc -f html "$OUTPUT_TEXT" -o "${Name}.docx" \
  --metadata title="Code Documentation" \
  --table-of-contents \
  --toc-depth=2 \
  --reference-doc=template.docx 2>/dev/null || \
pandoc -f html "$OUTPUT_TEXT" -o "../../word/${Name}.docx"

rm "all_contents.txt"

echo "Conversion complete: ${Name}.docx"