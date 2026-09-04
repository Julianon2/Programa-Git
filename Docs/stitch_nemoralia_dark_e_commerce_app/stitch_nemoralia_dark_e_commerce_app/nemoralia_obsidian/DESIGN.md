# Design System Specification: The Midnight Editorial

## 1. Overview & Creative North Star
The Creative North Star for this design system is **"The Midnight Editorial."** 

We are moving away from the "standard e-commerce template" and toward a high-end digital boutique experience. This system leverages the tension between the deep, obsidian-like background (`#12121d`) and the surgical precision of the red accent (`#E40E20`). 

By utilizing intentional asymmetry, expansive negative space, and architectural typography, we create an environment that feels curated rather than crowded. We treat the screen not as a grid of boxes, but as a series of layered, atmospheric planes.

---

## 2. Colors & Tonal Architecture
The palette is rooted in Material Design 3 logic but applied with a high-fashion, editorial lens.

*   **Primary Accent (`primary_container`: #E40E20):** This is our "heartbeat" color. It must be used sparingly to guide the eye to the most critical actions.
*   **The Background (`surface`: #12121d):** Our canvas is deep and immersive. 

### The "No-Line" Rule
**Explicit Instruction:** Prohibit the use of 1px solid borders for sectioning or containment. 
Boundaries must be defined through **background color shifts**. To separate a product grid from a hero section, transition from `surface` to `surface_container_low`. This creates a sophisticated, seamless flow that feels organic rather than mechanical.

### Surface Hierarchy & Nesting
Treat the UI as a physical stack of materials. Use the `surface_container` tiers to define depth:
*   **Base:** `surface` (#12121d)
*   **In-page Sections:** `surface_container_low` (#1b1a26)
*   **Cards/Modals:** `surface_container_high` (#292935)
*   **Active/Floating Elements:** `surface_container_highest` (#343440)

### The "Glass & Gradient" Rule
To add "soul" to the dark theme:
*   **Navigation & Overlays:** Use `surface_container` with a `backdrop-blur` (12px-20px) and 60-80% opacity. 
*   **Brand Moments:** For main CTAs, use a subtle radial gradient from `primary_container` (#E40E20) to `secondary_container` (#8d1416) to provide a sense of 3D volume.

---

## 3. Typography: The Architectural Voice
We utilize two distinct typefaces to create a premium hierarchy: **Epilogue** for structural impact and **Manrope** for functional clarity.

*   **Display & Headline (Epilogue):** These are your "billboard" moments. Use `display-lg` (3.5rem) with tight letter-spacing (-0.02em) for hero sections. The architectural nature of Epilogue conveys authority and modern luxury.
*   **Titles & Body (Manrope):** Manrope’s geometric cleanliness ensures readability in dark mode. Use `body-lg` (1rem) for product descriptions and `title-sm` (1rem) for UI labels.
*   **Contrast is Key:** Always pair a large `headline-lg` with a significantly smaller `label-md` to create an editorial "white space" feel.

---

## 4. Elevation & Depth
Depth in this system is achieved through **Tonal Layering** rather than traditional drop shadows.

### The Layering Principle
Place a `surface_container_lowest` card on a `surface_container_low` background to create a soft "recessed" look. This "stacking" of colors mimics natural light falloff in a dark room.

### Ambient Shadows
When an element must float (e.g., a "Quick Buy" FAB):
*   **Blur:** 24px - 40px
*   **Opacity:** 4% - 8%
*   **Color:** Use a tinted version of `on_surface` (a deep violet-grey) rather than pure black.

### The "Ghost Border" Fallback
If an edge case requires a border for accessibility:
*   Use the `outline_variant` token at **20% opacity**.
*   **Never** use 100% opaque borders; they shatter the "Midnight Editorial" immersion.

---

## 5. Components

### Navigation Bar
*   **Style:** Fixed at the top with a `backdrop-blur` effect.
*   **Layout:** Logo left, links centered, utilities (Cart/Profile) right. 
*   **Interaction:** Links use `on_surface_variant` and transition to `on_surface` (white) with a 2px `primary_container` dot underneath when active.

### Buttons
*   **Primary:** `primary_container` background, `on_primary_container` text. Roundedness: `md` (0.75rem).
*   **Secondary:** Ghost style using the "Ghost Border" rule.
*   **Tertiary:** Text-only with an arrow icon. Use for "View All" or "Read More."

### Cards & Product Grids
*   **Forbid Dividers:** Use `md` (1rem) or `lg` (1.5rem) spacing to separate items.
*   **Background:** Use `surface_container_low`. On hover, shift to `surface_container_high` with a subtle scale (1.02x).
*   **Image Handling:** Product images should have a `md` corner radius and sit flush against the top of the card.

### Input Fields
*   **State:** Default state is `surface_container_high`.
*   **Active State:** The bottom edge glows with a 2px `primary_container` line.
*   **Error State:** Use `error` (#ffb4ab) for the label and a subtle `error_container` glow.

### Chips & Filters
*   **Shape:** `full` (9999px) for a "pill" look.
*   **Selected:** `primary_container` background with `on_primary_container` text.

---

## 6. Do's and Don'ts

### Do:
*   **Embrace Negative Space:** Give elements 2x more breathing room than you think they need.
*   **Use Intentional Asymmetry:** In hero sections, align text left and imagery slightly offset to the right to create dynamic energy.
*   **Check Accessibility:** Ensure the red accent (`#E40E20`) maintains a 4.5:1 ratio against the dark background when used for text (use `primary_fixed` for smaller text if needed).

### Don't:
*   **No Hard Boxes:** Never use a #000000 stroke or a 100% opaque border.
*   **No Standard Grids:** Avoid the "Pinterest" look. Vary your column widths in editorial sections to keep the eye moving.
*   **Avoid Over-Saturation:** Don't flood the screen with red. The red is a laser, not a paint bucket.