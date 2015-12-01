/**
 * Title: Visual Modeler for GridSim Toolkit Description: This Visual Modeler
 * enables the user to quickly create experiments on different Grid testbeds and
 * generate the default Grid Broker source codes (in Java).
 *
 * $Id:$
 *
 * @author Anthony Sulistio and Chee Shin Yeo
 * @version 1.0
 */
package gridcomputingsystem.model.utilities;

import java.io.File;
import java.util.*;
import java.util.Enumeration;
import javax.swing.filechooser.*;

/**
 * A DefaultFileFilter, once implemented, can be set on a JFileChooser to keep
 * unwanted files from appearing in the directory listing.
 */
public class DefaultFileFilter extends FileFilter {

    private Hashtable<String, Object> filters_;
    private String desc_ = null;
    private String fullDesc_ = null;

    /**
     * Construct a default file filter to filter a file extension.
     *
     * @param ext File extension to filter
     * @param desc Description of this filter, eg. "JPG and GIF Images"
     */
    public DefaultFileFilter(String ext, String desc) {
        this.filters_ = new Hashtable<>();
        if (ext != null) {
            addExtension(ext);
        }

        if (desc != null) {
            setDescription(desc);
        }
    }

    /**
     * Construct a default file filter to filter some file extensions.
     *
     * @param ext File extensions to filter
     * @param desc Description of this filter, eg. "JPG and GIF Images"
     */
    public DefaultFileFilter(String[] ext, String desc) {
        this.filters_ = new Hashtable();
        for (int i = 0; i < ext.length; i++) {
            // add filters one by one
            addExtension(ext[i]);
        }

        if (desc != null) {
            setDescription(desc);
        }
    }

    /**
     * Whether the given file is accepted by this filter.
     *
     * @param f File
     * @return      <code>true</code> if file is accepted <code>false</code>
     * otherwise.
     */
    public boolean accept(File f) {
        if (f != null) {
            if (f.isDirectory()) {
                return true;
            }

            String ext = getExtension(f);
            if (ext != null && filters_.get(ext) != null) {
                return true;
            }
        }

        return false;
    }

    /**
     * Get the file extension of the file.
     *
     * @param f File
     * @return File extension
     */
    public String getExtension(File f) {
        if (f != null) {
            String filename = f.getName();
            int i = filename.lastIndexOf('.');
            if (i > 0 && i < filename.length() - 1) {
                return filename.substring(i + 1).toLowerCase();
            }
        }

        return null;
    }

    /**
     * Get the file name without its file extension.
     *
     * @param fileName Filename with file extension
     * @return Filename without file extension
     */
    public String getFileNameOnly(String fileName) {
        int i = fileName.lastIndexOf('.');
        if (i > 0 && i < fileName.length() - 1) {
            return fileName.substring(0, i);
        }

        return fileName;
    }

    /**
     * Add the file extension.
     *
     * @param extension File extension
     */
    private void addExtension(String extension) {
        if (filters_ == null) {
            filters_ = new Hashtable(5);
        }

        filters_.put(extension.toLowerCase(), this);
        fullDesc_ = null;
    }

    /**
     * Get the description of this filter.
     *
     * @return Description
     */
    public String getDescription() {
        if (fullDesc_ == null) {
            if (desc_ == null) {
                fullDesc_ = (desc_ == null) ? "(" : desc_ + " (";

                // build the description from the extension list
                Enumeration extensions = filters_.keys();
                if (extensions != null) {
                    fullDesc_ += "." + (String) extensions.nextElement();

                    while (extensions.hasMoreElements()) {
                        fullDesc_ += ", .";
                        fullDesc_ += (String) extensions.nextElement();
                    }
                }

                fullDesc_ += ")";
            } else {
                fullDesc_ = desc_;
            }
        }

        return fullDesc_;
    }

    /**
     * set the description for this filter.
     *
     * @param desc Description.
     */
    private void setDescription(String desc) {
        desc_ = desc;
        fullDesc_ = null;
    }

} // end class
